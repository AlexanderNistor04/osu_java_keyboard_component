# osu_java_keyboard_component
a custom java data structure representing the keys in a keyboard as a 2d char array built in the style of Ohio State components

The keyboard component is structured like the osu cse components, in that, it has an interface at the top (KeyboardKernel) of the heirarchy with the method headers of only the most basic method necessary to use the component (kernel methods). Then, another interface (Keyboard) extends the kernel interface and includes the method headers of the more advanced methods (secondary methods). Then, there's an abstract class (KeyboardSecondary) which implements only the secondary methods using exclusively kernel methods. Then, there's a class (Keyboard1) which implements the kernel methods and inherits from the abstract class. 
