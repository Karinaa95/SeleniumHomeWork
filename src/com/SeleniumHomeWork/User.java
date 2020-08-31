package com.SeleniumHomeWork;

public class User {
    public String firstName;
    public String lastName;
    public String email;
    public String phone;
    public String mobilePhone;
    public String password;
    public int gender;
    public int position;

    private static String getRandomNum(int length) {
        String randomNum = "";
        randomNum = randomNum + ((int) (Math.random() * Math.pow(10, length)));
        return randomNum;
    }

    private static String getRandomPhone(int length) {
        String randomPhone = "";
        if (length == 12) {
            int [] mnc_array = {50, 63, 66, 67, 68, 91, 92, 93, 97, 96};
            int mcc = mnc_array[(int) Math.random() * mnc_array.length];
            randomPhone = "380" + mcc + (int) (Math.random() * Math.pow(10, length - 5));
            return randomPhone;
        }
        randomPhone = randomPhone + (int) (Math.random() * Math.pow(10, length));
        return randomPhone;
    }

    User () {
        this.firstName = "test" + getRandomNum(5);
        this.lastName = "test" + getRandomNum(5);
        this.phone = getRandomPhone(10);
        this.mobilePhone = getRandomPhone(12);
        this.email = "test" + getRandomNum(5) + "@gmail.com";
        this.password = "TestPassw" + getRandomNum(4);
        this.gender = (int) (Math.random() * 1 + 1);
        this.position = (int) (Math.random() * 3 + 1);
        System.out.printf(
                            "\n--- User Info ---\n" +
                            "firstName: %s lastName: %s\n" +
                            "E-mail: %s\n" +
                            "Phone: %s\n" +
                            "Mobile Phone: %s\n" +
                            "Password: %s\n" +
                            "Gender: %s\n" +
                            "Position: %s\n",
                            this.firstName, this.lastName, this.email, this.phone, this.mobilePhone, this.password, this.gender, this.position
                         );
    }
}
