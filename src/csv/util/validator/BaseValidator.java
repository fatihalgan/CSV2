package csv.util.validator;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;

import csv.util.validator.exception.ValidateException;

public class BaseValidator {
		
	public static String getMessage(String key){
		FacesContext context = FacesContext.getCurrentInstance();		
		try{
			String result = ResourceBundle.getBundle(context.getApplication().getMessageBundle(),context.getViewRoot().getLocale()).getString(key);
			if(isNullOrBlank(result))
				result = ResourceBundle.getBundle(context.getApplication().getMessageBundle(),new Locale("en")).getString(key);
			return result;
		}catch(Exception e){
			try{
				return ResourceBundle.getBundle(context.getApplication().getMessageBundle(),new Locale("en")).getString(key);
			}catch(Exception e2){
				return "Validation message could not be found for the key===="+key;
			}
		}
	}
	
	public static boolean isNullOrBlank(String str){
		return null==str || "".equals(str.trim());
	}
	
	public static boolean isNullOrZero(Integer i){
		return null==i || 0==i.intValue();
	}
	
	public static boolean isNullOrZero(Long l){
		return null==l || 0==l.intValue();
	}
	
	public static void checkText(String str) throws ValidateException {
		checkText(str,0);
	}
	
	public static String checkText(String str,int maxLength) throws ValidateException {
		if(isNullOrBlank(str)){
			throw new ValidateException(getMessage("errorNoReasonValue"));
		}
		if(maxLength!=0 && str.length()>maxLength){
			throw new ValidateException(getMessage("errorMaxLengthExceeded"));
		}
		String result = str.replaceAll("\n", " ");
		String regex = "[\\w. ,]*";//"[a-zA-Z_0-9]*";
		if(!Pattern.matches(regex, result)){
			throw new ValidateException(getMessage("errorInvalidCharacter"));
		}
		return result;
	}
	
	public static void checkEmailFormat(String email) throws ValidateException{
		if(isNullOrBlank(email))return;
		String regex = "[\\w][\\w.]*[@][\\w][\\w]*[.][\\w][\\w.]*";
		if(!Pattern.matches(regex, email)){
			throw new ValidateException(getMessage("errorInvalidEmail"));
		}
	}
	
	public static void validateMsisdn(String prefix,String msisdn) throws ValidateException {
		if(isNullOrBlank(prefix) || isNullOrBlank(msisdn) || !prefix.matches("[+]*[0-9]*") || !msisdn.matches("[0-9^]{7}")) {
			throw new ValidateException(getMessage("errorIncorrectMsisdnFormat"));
		}
	}
	
	public static void validateMsisdn(String msisdn) throws ValidateException{
		if((msisdn.startsWith("25882") || msisdn.startsWith("25883")) && msisdn.length() > 7) validateMsisdn(msisdn.substring(0, 5), msisdn.substring(5));
		validateMsisdn("25882",msisdn);
	}
}
