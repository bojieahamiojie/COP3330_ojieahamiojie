public class ContactItem {
    private String first;
    private String last;
    private String phone;
    private String email;

    public ContactItem(){
        this.first = "";
        this.last = "";
        this.phone = "";
        this.email = "";
    }

    public ContactItem(String first, String last, String phone, String email){
        this.first = first;
        this.last = last;
        this.phone = phone;
        this.email = email;
    }

    public String getFirst(){
        return first;
    }

    public boolean setFirst(){
        if(!this.validateFirst(first)){
            System.out.println("\nWARNING: First name must be at least 1 character long; contact not created\n");
            return false;
        }
        this.first = first;
        return true;
    }

    public String getLast(){
        return last;
    }

    public boolean setLast(){
        if(!this.validateLast(last)){
            System.out.println("\nWARNING: Last name must be at least 1 character long; contact not created\n");
            return false;
        }
        this.last = last;
        return true;
    }

    public String getPhone(){
        return phone;
    }

    public boolean setPhone(){
        if(!this.validatePhone(phone)){
            System.out.println("\nWARNING: Invalid phone number; contact not created\n");
            return false;
        }
        this.phone = phone;
        return true;
    }

    public String getEmail(){
        return email;
    }

    public boolean setEmail(){
        if(!this.validateEmail(email)){
            System.out.println("\nWARNING: Invalid email address; contact not created\n");
            return false;
        }
        this.email = email;
        return true;
    }

    public boolean validateFirst(String first){
        if(first.length() < 1)
            return false;
        return true;
    }

    public boolean validateLast(String last){
        if(last.length() < 1)
            return false;
        return true;
    }

    public boolean validatePhone(String phone){
        String[] parsedPhone = phone.split("-");

        if(parsedPhone.length != 3)
            return false;

        String areaCode = parsedPhone[0];
        String threeDigitPrefix = parsedPhone[1];
        String lineNumber = parsedPhone[2];

        if(areaCode.length() != 3 || !(areaCode.matches("[0-9]+")))
            return false;
        if(threeDigitPrefix.length() != 3 || !(threeDigitPrefix.matches("[0-9]+")))
            return false;
        if (lineNumber.length() != 4 || !(lineNumber.matches("[0-9]+")))
            return false;

        return true;
    }

    public boolean validateEmail(String email){
        String[] parsedEmail = email.split("\\s*\\@\\s*.");

        if(parsedEmail.length != 3)
            return false;

        String userName = parsedEmail[0];
        String serverName = parsedEmail[1];
        String domainName = parsedEmail[2];

        if(userName.length() < 1)
            return false;
        if(serverName.length() < 1)
            return false;
        if(domainName.length() < 1)
            return false;

        return true;
    }
}
