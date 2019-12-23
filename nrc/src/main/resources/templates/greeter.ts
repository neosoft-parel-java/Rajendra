class Student {
    fullName: String;
    constructor(public firstName: string, public middleInitial: string, public lastName: string) {
        this.fullName = firstName + " " + middleInitial + " " + lastName;
    }
}

interface Person {
    firstName: string;
    lastName: string;
}

function greeter(person: Person) {
    return "Hello, "+ person.firstName + " " + person.lastName;
}

let user = { firstName: "Polos", middleInitial: "V.", lastName: "Harmanos"};

document.body.textContent = greeter(user);