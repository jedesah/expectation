val testRunner = test {
	eval(_) {
		"expression" {
			("1") -> 1
			("1 + 1") -> 3
			("1 + Random.getPositiveInt") -> _ >= 1
		}
		"value definition" #valDef {
			("val a = 5") -> ()
			#multipleStatement ("val a = 5; a") -> 5
			"with declared type" #multipleStatement ("val a: Int = 5; a") -> 5
		}
	}
}

testRunner.execute(parallel = true, tags = "valDef") -> TestResult(
															results = Map("eval" -> Map("expression" -> Map("1" -> Success, "1 + 1" -> Failure))...
															time = Duration(...)
														)