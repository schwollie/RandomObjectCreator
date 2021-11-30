# RandomObjectCreator

With this Project it is possible to create Randomized Objects from a class.

To create such a Random Object just write:

'''
ObjectBuilder b = ObjectBuilder.getObjectBuilderFromClass(TestClass.class);
TestClass a = (TestClass) b.generateObject();
'''
