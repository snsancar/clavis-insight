# Number Finder

Fastest way to find a number in a list of numbers using custom compare method provided by Clavis Insight.

###Technologies Used

- Java 8
- Jackson
- Junit

###Solution

The reason for using HashSet
  -- Stores only Unique numbers, if the JSON file contains more duplicates it's better store only unique numbers.
  -- Does not iterate in the sequence, so the probability of finding the number is faster than the List sequential approach.
  -- Also, we are breaking the loop by not iterating the entire HashSet using findFirst() method.
  -- used Java 8 Streams API for iterating HashSet.

###Assumption

JSON File contains only numbers, otherwise FasterComparator compare method should handle the exception.
The requirement clearly says not to change anything in the FasterComparator class.


