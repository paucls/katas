export class Greeter {
    constructor(private name: String) {}

    sayHello(): string {
        return `Hello, ${this.name}!`;
    }
}
