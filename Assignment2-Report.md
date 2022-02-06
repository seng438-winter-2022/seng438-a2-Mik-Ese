**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      |27|
| -------------- | --- |
|Michele|Esercitato|
|Dylan|Mah|
|Faisal|Hossain|
|Cheyenne|Goh|

**Table of Contents**
1. [Introduction](#introduction)
2. [Detailed description of unit test strategy](#detailed-description-of-unit-test-strategy)
3. [Test cases developed](#test-cases-developed)
4. [How the team work/effort was divided and managed](#how-the-team-workeffort-was-divided-and-managed)
5. [Difficulties encountered, challenges overcome, and lessons learned](#difficulties-encountered-challenges-overcome-and-lessons-learned)
6. [Comments/feedback on the lab itself](#commentsfeedback-on-the-lab-itself)

# 1 Introduction
This lab was used to teach students about unit testing designed using black-box testing, Equivalence Class Testing(ECT), and Boundary Value Testing. Additionally it familiarized the students with Eclipse IDE, for Java development. Before the lab we were aware of the utilization of JUnit 4 to perform unit tests. Over the course of the lab, we gained experience with Mock Frameworks using the JMock library provided. With this we tested certain classes within the JFreeChart library.

# 2 Detailed description of unit test strategy
The Unit testes were devised according to the principles of black-box testing, Equivalence Class Testing(ECT), and Boundary Value Testing. We partitioned our test inputs into 3 subsets, One had generalized legal inputs, another tested inputs near the boundaries which includes legal and illegal inputs, and the last tested the boundaries themselves.

// including the input partitions you have designed

# 3 Test cases developed
The test cases built, were for the `Range` class and the `DataUtilities` class contained in the `JFreeChart` library.
The tests followed the [Test Plan]() which as specified in section 1.1.1, 
the methods tested in the Range class were:
- `getCentralValue`
    - `centralValueShouldBeZero` - belongs to the generalized legal inputs partition
    - `centralValueShouldBeOnePointFive` - belongs to the generalized legal inputs partition
    - `centralValueShouldBeNegOnePointFive` - belongs to the generalized legal inputs partition
    - `centralValueShouldNotBeAboveZero` - belongs to the inputs near boundaries partition
    - `centralValueShouldNotBeBelowZero` - belongs to the inputs near boundaries partition
    - `centralValueShouldBeFiveHundMil` - belongs to the generalized legal inputs partition
- `getUpperBound`
    - `upperBoundShouldBeOne` - belongs to the boundary inputs partition
    - `upperBoundShouldNotBeAboveOne` - belongs to the inputs near boundaries partition
    - `upperBoundShouldNotBeBelowOne` - belongs to the inputs near boundaries partition
    - `upperBoundShouldBeTwoBil` - belongs to the boundary inputs partition
- `getLowerBound`
    - `lowerBoundShouldBeNegOne` - belongs to the boundary inputs partition
    - `lowerBoundShouldNotBeAboveNegOne` - belongs to the inputs near boundaries partition
    - `lowerBoundShouldNotBeBelowNegOne` - belongs to the inputs near boundaries partition
    - `lowerBoundShouldBeNegOneBil` -belongs to the boundary inputs partition
- `contains`
    - `rangeShouldContainZeroPointNine` - belongs to the generalized legal inputs partition
    - `rangeShouldContainNegZeroPointNine` - belongs to the generalized legal inputs partition
    - `rangeShouldNotContainValHigherThanOne` - belongs to the inputs near boundaries partition
    - `rangeShouldNotContainValLowerThanNegOne` - belongs to the inputs near boundaries partition
- `isNaNRange`
    - `neitherBoudryIsNaN` - belongs to the generalized legal inputs partition
    - `lowerBoundryIsNotNaNUpperBoudryIsNaN` - belongs to the inputs near boundaries partition
    - `lowerBoundryIsNaNUpperBoudryIsNotNaN` - belongs to the inputs near boundaries partition
    - `rangeBoundriesAreNaN` - belongs to the boundary inputs partition

and the methods tested in the Data Utilities class were:
- `equals`
    - test
- `calculateColumnTotal`
    - `calculateColumnTotalNoCols` - belongs to the generalized legal inputs partition
    - `calculateColumnTotalAllPosInt` - belongs to the generalized legal inputs partition
    - `calculateColumnTotalAllNegInt` - belongs to the generalized legal inputs partition
    - `calculateColumnTotalMixedInt` - belongs to the generalized legal inputs partition
    - `calculateColumnTotalAllPosDec` - belongs to the generalized legal inputs partition
    - `calculateColumnTotalAllNegDec` - belongs to the generalized legal inputs partition
    - `calculateColumnTotalMixedDec` - belongs to the generalized legal inputs partition
- `calculateRowTotal`
    - `calculateRowTotalNoRows` - belongs to the generalized legal inputs partition
    - `calculateRowTotalAllPosInt` - belongs to the generalized legal inputs partition
    - `calculateRowTotalAllNegInt` - belongs to the generalized legal inputs partition
    - `calculateRowTotalMixedInt` - belongs to the generalized legal inputs partition
    - `calculateRowTotalAllPosDec` - belongs to the generalized legal inputs partition
    - `calculateRowTotalAllNegDec` - belongs to the generalized legal inputs partition
    - `calculateRowTotalMixedDec` - belongs to the generalized legal inputs partition
- `createNumberArray`
    - test
- `getCumulativePercentages`
    - `cumulativePercentageAtZeroShouldBeTenPercent` - 
    - `cumulativePercentageAtOneShouldBeOneHundredPercent` - 
    - `keyAtZeroShouldBeEleven` - 
    - `keyAtOneShouldBeTwentyTwo` - 
    - `cumulativePercentageAtZeroShouldBeNegTenPercent` - 

The tests developed are detailed in the [Here](https://github.com/seng438-winter-2022/seng438-a2-Mik-Ese/blob/main/TestCase.xls).

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed
Everyone worked together to write up the Test Plan and decide the pairs.

The tests were developed in 2 pairs:
- Michele Esercitato and Dylan Mah 
- Faisal Hossain and Cheyenne Goh

The first pair covered the test cases for the `Range` class and the second pair the `DataUtilities` class. After which, the pairs switched their target classes and reviewed the test cases built.

# 5 Difficulties encountered, challenges overcome, and lessons learned
### Difficulties encountered
- Input Partitioning of the test cases

### Challenges overcome
- IDE setup for JUnit4 and all the external libraries and its associated troubleshooting

### Lessons learned
- Utilization of the Java Mock Framework—JMock

# 6 Comments/feedback on the lab itself
Interesting lab to learn the basics of unit testing
