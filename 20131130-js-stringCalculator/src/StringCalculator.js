function StringCalculator() {}

StringCalculator.prototype.add = function(addends) {
	if (addends === "")
		return 0;

	var result = 0;

	var delimiterRegex = ",\n";

	var arrayAddends = addends.split(new RegExp("["+delimiterRegex+"]"));
	arrayAddends.forEach(function(addend) {
		result = result + parseInt(addend);
	});

	return result;
};