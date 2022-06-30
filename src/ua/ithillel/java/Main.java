package ua.ithillel.java;

public class Main {

    public static void main(String[] args) {

        Restrictions cs = new Restrictions();

        cs.limitAge = 18;
        cs.quantityStock = 100;
        cs.creditMonth = 36;

        Customer client = new Customer();

        client.name = "Elon Musk";
        client.gender = "Male";
        client.age = 18;
        client.balance = 100000;
        client.buyCredit = true;

        Car carOrder = new Car();
        carOrder.mark = "Tesla";
        carOrder.model = "Roadster";
        carOrder.value = 2;
        carOrder.price = 75000;
        carOrder.sum = carOrder.value * carOrder.price;

        if (cs.limitAge > client.age) {
            cs.afterMuch = cs.limitAge - client.age;
            System.out.println("\nSorry " + client.name + " come through after " + cs.afterMuch + " year.");
        }

        if (client.age >= cs.limitAge && client.balance >= carOrder.price * carOrder.value && cs.quantityStock > 0) {
            client.balance -= carOrder.price * carOrder.value;
            cs.quantityStock -= carOrder.value;
            System.out.println("\n" + client.name + " congratulations on your purchase. Your balance " + client.balance);
        }

        if (client.buyCredit) {
            if (client.age >= cs.limitAge && cs.quantityStock > 0 && carOrder.price > client.balance) ;

            int creditSum = carOrder.sum - client.balance;
            int sumMonth = creditSum / cs.creditMonth;
            cs.quantityStock -= carOrder.value;
            System.out.println("\n" + client.name + " congratulations on buying a car on credit. Monthly payment for " +
                    "36 months is " + sumMonth);

        } else {
            if (!client.buyCredit) ;
            System.out.println("\n" + client.name + " come back later.");
        }
        System.out.println("\nThe rest of these cars in the showroom = " + cs.quantityStock);
    }
}


