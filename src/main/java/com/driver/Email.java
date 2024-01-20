package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }
    public Email(){}
    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        if(oldPassword.equals(password)){
            if(newPassword.length()>=8){
                boolean upper=false,lower=false,digit=false,special=false;
                for(int i=0;i<newPassword.length();i++){
                    if(newPassword.charAt(i)>='A' && newPassword.charAt(i)<='Z')
                        upper=true;
                    else if(newPassword.charAt(i)>='a' && newPassword.charAt(i)<='z')
                        lower=true;
                    else if(newPassword.charAt(i)>='0' && newPassword.charAt(i)<='9')
                        digit=true;
                    //if(newPassword.charAt(i)>='A' && newPassword.charAt(i)<='Z')
                    else
                        special=true;
                }
                if(upper && lower && digit && special) {
                    password=newPassword;
                }
            }
        }


        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
}
