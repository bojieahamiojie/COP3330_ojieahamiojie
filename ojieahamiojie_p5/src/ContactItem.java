public class ContactItem {
    private String first;
    private String last;
    private String phone;
    private String email;
    private boolean marked;

    public ContactItem(){
        this.first = "";
        this.last = "";
        this.phone = "";
        this.email = "";
        this.marked = false;
    }

    public ContactItem(String first, String last, String phone, String email, boolean marked){
        this.first = first;
        this.last = last;
        this.phone = phone;
        this.email = email;
        this.marked = marked;
    }

    public String getFirst(){
        return first;
    }

    public boolean setFirstName(String first){
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

    public boolean setLastName(String last){
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

    public boolean setPhoneNumber(String phone){
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

    public boolean setEmailAddress(String email){
        if(!this.validateEmail(email)){
            System.out.println("\nWARNING: Invalid email address; contact not created\n");
            return false;
        }
        this.email = email;
        return true;
    }

    public boolean isMarkedEdited(){
        return marked;
    }

    public void setMarkedEdited(){
        this.marked = true;
    }

    public void setUnmark(){
        this.marked = false;
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
        if(lineNumber.length() != 4 || !(lineNumber.matches("[0-9]+")))
            return false;

        return true;
    }

    public boolean validateEmail(String email){
        String[] parsedEmail = email.split("@|\\.");

        if(parsedEmail.length != 3)
            return false;

        String userName = parsedEmail[0];
        String serverName = parsedEmail[1];
        String domainName = parsedEmail[2];

        if(userName.length() < 1 || userName.matches(""))
            return false;
        if(serverName.length() < 1 || serverName.matches(""))
            return false;
        if(domainName.length() < 1 || domainName.matches(""))
            return false;

        return true;
    }
}
