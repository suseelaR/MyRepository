const executeTask = () =&gt; {
const numInput = document.getElementById(&quot;numInput&quot;) as HTMLInputElement;
const caseInput = document.getElementById(&quot;caseInput&quot;) as HTMLInputElement;
const resultArea = document.getElementById(&quot;result&quot;) as HTMLElement;
const n = parseInt(numInput.value);
const choice = parseInt(caseInput.value);
let output = &quot;&quot;;
switch (choice) {
case 1: // Even series using for loop
output = &quot;Even Series: &quot;;
for (let i = 0; i &lt;= n; i++) {
if (i % 2 === 0) output += i + &quot; &quot;;
}

break;
case 2: // Fibonacci series using while loop
output = &quot;Fibonacci Series: &quot;;
let a = 0, b = 1, next = 0;
while (a &lt;= n) {
output += a + &quot; &quot;;
next = a + b;
a = b;
b = next;
}
break;
case 3: // Strong Number check using do...while loop
let temp = n;
let sum = 0;
do {
let digit = temp % 10;
let fact = 1;
for (let i = 1; i &lt;= digit; i++) fact *= i;
sum += fact;
temp = Math.floor(temp / 10);
} while (temp &gt; 0);

output = (sum === n) ? `${n} is a Strong Number.` : `${n} is NOT a Strong Number.`;
break;
default:
output = `Checked number: ${n}. Please select a valid case (1, 2, or 3).`;
}
resultArea.innerText = output;
};
document.getElementById(&quot;btn&quot;)?.addEventListener(&quot;click&quot;, executeTask);
