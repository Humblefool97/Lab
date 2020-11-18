# Navigation
- Navigation component helps us implement navigation , from simple button clicks to more complex patterns, such as app bars and the navigation drawer
- Destination: Different content areas in the app
- Actions : Logical connections between destinations that form a path users can take

- Consists of 3 main parts
    - Nav graph : Resource file that Contains all the navigation related information related to the app.Indiviual content areas are called as destinations
    - Nav Host : Basically a window that uses the information in the Nav graph to perform fragment transaction
    - Nav controller : Object the instructs the navigation to occur.An Empty container where destinations are swapped


Principles of Navigation

- Fixed start destination : The first you visit when you enter the app should be the last screen when you want to exit the app
- Navigation state is reperesented as stack of destinations with top of the stack being the current screen and the start desination being the base of the stask
- Up button (<-) never exits the app & should not appear in the start

Creating a navigation graph:
- Navigation occurs begtween destinations which are connected via Actions

- `android:name` contains the class name of our NavHost imeplementation
- `android:navGraph` provides info about our nav graph
- `app:defaultNavHost = true` , means it intercepts the back button and it is the default one if we have one or more NavHosts(Two - pane layouts)

SafeArgs:
- Recommended way of navigation which ensures type safe navigation and argument passing between destinations
- After adding saferargs, build
- This generates a class for each originiting destination,from which the action is orignated
- Combination of className+"Directions"

### Nested graphs
- nav graph inside a nav graph
- For ex:
    - Instead of including Registration flow,with the rest of the app
    - You can create a Registration flow as sepearte nav_graph and use it
    - Use `<include graph = "@navigation/in_game_navigation">`
    - By doing this
    -  you can include nav grpah present in other modules as well


### Global action
- Use global actions to represnt actions that are common from multiple destinations
- For ex: You might want to end up in first fragment from 3rd / 4th on some action
- How ?
    - Add `<!-- Global action--><action
        android:id="@+id/action_global_firstFragement"
        app:destination="@id/firstFragement" />`
    - Use the id of the global action to navigate

### Navigate to destination
- Navigating to a destination is done by `NavController`
- A navcontroller can be obtained by
    - A View , using findNavController
    - A fragment, from findNavController()
    - An actviity, from findNavController(viewId)

- You can navigate to destination using
    - action
    - id , of the action
- When we add an action to a destination , Navigation comp creates a `NavAction` class that contains
    - destination : target destination
    - default args
    - Navigation options : Like animation(enter/exit),launch mode..etc
- When pressed up/back ,NavController calls .navigateUp() / popBackStack()
- popBackStack returns boolean based on success/failure
- Fails, if you are trying to pop backtsack when the back stack is with only base destination
- so do ` if(!navController.popBackStack()) finish()`
- If there's a circular logic involved , use popUpToInlcusive="true" & popUpTo
    - for ex: A -> B -> C ->A, you want to pop C & B while coming back to A in step (C->A)


### Passing data
https://developer.android.com/guide/navigation/navigation-pass-data

https://developer.android.com/guide/navigation/navigation-custom-back
