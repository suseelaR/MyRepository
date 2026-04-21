function process(): void {

    let num = Number((document.getElementById("num") as HTMLInputElement).value);
    let choice = Number((document.getElementById("choice") as HTMLSelectElement).value);

    let result = "";

    switch (choice) {

        case 1:
            // Even Series using for loop
            result = "Even Series: ";

            for (let i = 2; i <= num; i += 2) {
                result += i + " ";
            }

            break;

        case 2:
            // Fibonacci Series using while loop
            let a = 0, b = 1, i = 0;

            result = "Fibonacci Series: ";

            while (i < num) {
                result += a + " ";

                let temp = a + b;
                a = b;
                b = temp;

                i++;
            }

            break;

        case 3:
            // Strong Number using do...while loop

            let temp = num;
            let sum = 0;

            do {

                let digit = temp % 10;
                let fact = 1;

                for (let j = 1; j <= digit; j++) {
                    fact = fact * j;
                }

                sum = sum + fact;
                temp = Math.floor(temp / 10);

            } while (temp > 0);

            if (sum == num)
                result = num + " is a Strong Number";
            else
                result = num + " is NOT a Strong Number";

            break;

        default:
            result = "Please enter a valid choice";
    }

    document.getElementById("result")!.innerHTML = result;
}
