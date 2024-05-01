import { Greeter } from "@/greeter";

describe('Greeter', () => {

    it('should say hello', () => {
        const greeter = new Greeter('John Doe');

        const greeting = greeter.sayHello();

        expect(greeting).toEqual('Hello, John Doe!');
    });

});
