vowels = "aeiou"
text = "all those who believe in psychokinesis raise my hand"
no_vowels = "".join(letter for letter in text if letter not in vowels)
vowel_output = "".join(letter for letter in text if letter in vowels)

print (no_vowels)
print (vowel_output)
		
