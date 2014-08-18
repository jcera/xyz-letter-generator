xyz-letter-generator
====================
> This is a common technical interview machine problem used by some companies I've applied for.
> Implementation is coded in `java`.

Problem Overview
----------
Write a program which prints X, Y, Z using asterisks based on an odd number scale.
The implementation should have two types: `horizontal` orientation and `vertical` orientation.

Example:
> scale of `3` will have an output of: <br>
> ```
> // horizontal
> * * * * ***
>  *   *   *
> * *  *  ***
>
> // vertical
> * *
>  * 
> * *
>
> * *
>  *  
>  *
>
> ***
>  *
> ***
> ```
> scale of `7` will have an output of: <br>
> ```
> // horizontal
> *     * *     * *******
>  *   *   *   *       * 
>   * *     * *       *  
>    *       *       *   
>   * *      *      *    
>  *   *     *     *    
> *     *    *    *******  
>
> // vertical
> *     *
>  *   * 
>   * *  
>    *   
>   * *  
>  *   * 
> *     *
>
> *     *
>  *   * 
>   * *  
>    *   
>    *  
>    *
>    *
> 
> *******
>      * 
>     *  
>    *   
>   *    
>  *    
> *******  
> ```

Proposed Implementation
----------------------
- `VerticalLetterGenerator.java` - class name for the vertical letter generator
- `HorizontalLetterGenerator.java` - class name for the horizontal orientation
- Two arguments will be played:
  1. `scale` - odd number integer, minimum value of `3`
  2. `letters` - array of letters `'X'`, `'Y'`, `'Z'`. Can be all of them or not.

- Implementation should at least show basic object-oriented concepts, and design patterns if possible.


Example:
```java
int scale = 3;

char[] letters = new char[] {'X', 'Z'};

VerticalLetterGenerator verticalLetterGenerator = new VerticalLetterGenerator(scale, letters);
// print output
```

