package designpatterns.builder;

public class ClaimCalculator {

    private final String claimId;
    private final String custId;
    private final String submitDate;
    private final String amount;
    private final String age;
    private final String address;
    private final String location;
    private final String limits;

    private ClaimCalculator(ClaimSBuilder claimSBuilder){
        this.claimId = claimSBuilder.claimId;
        this.custId = claimSBuilder.custId;
        this.amount = claimSBuilder.amount;
        this.submitDate = claimSBuilder.submitDate;
        this.age  = claimSBuilder.age;
        this.address = claimSBuilder.address;
        this.location = claimSBuilder.location;
        this.limits = claimSBuilder.limits;
    }

    public String getClaimId() {
        return claimId;
    }

    public String getCustId() {
        return custId;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public String getAmount() {
        return amount;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }

    public String getLimits() {
        return limits;
    }

    public static class ClaimSBuilder {
        private String claimId;
        private String custId;
        private String submitDate;
        private String amount;
        private String age;
        private String address;
        private String location;
        private String limits;

        public ClaimSBuilder(String claimId, String custId, String submitDate, String amount){
            this.claimId = claimId;
            this.custId = custId;
            this.submitDate = submitDate;
            this.amount = amount;
        }

        public ClaimSBuilder setAge(String age){
            this.age = age;
            return this;
        }

        public ClaimSBuilder setAddress(String address){
            this.address = address;
            return this;
        }

        public ClaimSBuilder setLocation(String location){
            this.location = location;
            return this;
        }

        public ClaimSBuilder setLimits(String limits){
            this.limits = limits;
            return this;
        }

        public ClaimCalculator build(){
            return new ClaimCalculator(this);
        }
    }

    @Override
    public String toString() {
        return "ClaimCalculator{" +
                "claimId='" + claimId + '\'' +
                ", custId='" + custId + '\'' +
                ", submitDate='" + submitDate + '\'' +
                ", amount='" + amount + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", location='" + location + '\'' +
                ", limits='" + limits + '\'' +
                '}';
    }
}
