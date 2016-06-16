export class PhoneNumberList {

    private phoneNumbers:string[];

    constructor(phoneNumbers:string[]) {
        this.phoneNumbers = phoneNumbers;
    }

    isConsistent() {
        var result = true;

        for (let i = 0; i < this.phoneNumbers.length; i++) {
            for (let j = i + 1; j < this.phoneNumbers.length; j++) {
                let phoneBIsPrefixOfA = this.phoneNumbers[i].indexOf(this.phoneNumbers[j]) === 0;
                let phoneAIsPrefixOfB = this.phoneNumbers[j].indexOf(this.phoneNumbers[i]) === 0;

                if (phoneAIsPrefixOfB || phoneBIsPrefixOfA) {
                    return false;
                }
            }
        }

        return result;
    }

}
