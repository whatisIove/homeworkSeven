package ua.ithillel.java;

public class OrderedTest {
    public static void main(String[] args) {

        Restrictions cs = new Restrictions();

        cs.limitAge = 18;
        cs.quantityStock = 100;
        cs.creditMonth = 36;

        Customer client = new Customer();

        client.name = "Musk Elon";
        client.gender = "Female";
        client.age = 81;
        client.balance = 1000000;

        Car carOrder = new Car();
        carOrder.mark = "Tesla";
        carOrder.model = "Model X";
        carOrder.value = 10;
        carOrder.price = 99999;
        carOrder.sum = carOrder.value * carOrder.price;

        boolean credit = false;

        extracted(cs, client, carOrder);

        if (credit) {
            if (client.age >= cs.limitAge && client.balance > carOrder.sum) ;

            int creditSum = carOrder.sum - client.balance;
            int sumMonth = creditSum / cs.creditMonth;
            cs.quantityStock -= carOrder.value;
            System.out.println("\n" + client.name + " congratulations on buying a car on credit. Monthly payment for " +
                    "36 months is " + sumMonth);


            if (!credit) ;
            System.out.println("\n" + client.name + " come back later.");
        }
        System.out.println("\nThe rest of these cars in the showroom = " + cs.quantityStock);
    }

    private static void extracted(Restrictions cs, Customer client, Car carOrder) {
        if (cs.limitAge > client.age) {
            cs.afterMuch = cs.limitAge - client.age;
            System.out.println("\nSorry " + client.name + " come through after " + cs.afterMuch + " year.");
        }

        if (client.age >= cs.limitAge && client.balance >= carOrder.price * carOrder.value && cs.quantityStock > 0) {
            client.balance -= carOrder.price * carOrder.value;
            cs.quantityStock -= carOrder.value;
            System.out.println("\n" + client.name + " congratulations on your purchase. Your balance " + client.balance);
        }
    }
}
