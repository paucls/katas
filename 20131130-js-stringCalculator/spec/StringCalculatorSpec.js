describe("StringCalculator", function() {

	describe("add", function() {

		it("for an empty string it will return 0", function() {
			var stringCalculator = new StringCalculator();
			var result = stringCalculator.add("");

			expect(result).toEqual(0);
		});

		it("for a string with a number it will return this number", function() {
			var stringCalculator = new StringCalculator();
			var result = stringCalculator.add("5");

			expect(result).toEqual(5);
		});

		it("for a string with multiple numbers it will return the sum of them", function() {
			var stringCalculator = new StringCalculator();
			var result = stringCalculator.add("5, 2, 3");

			expect(result).toEqual(10);
		});

		it("allows new lines as number separator", function() {
			var stringCalculator = new StringCalculator();
			var result = stringCalculator.add("5\n2");

			expect(result).toEqual(7);
		});

	});

});