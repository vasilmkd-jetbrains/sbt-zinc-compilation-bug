object Scope {
  class MyClass
  opaque type MyOpaqueType = String
  type MyTypeClass = String
  extension (t: MyTypeClass)
    def myExtensionForAlias: String = "42"
  extension (t: MyClass)
    def myExtensionForClass: String = "42"
  extension (t: MyOpaqueType)
    def myExtensionForOpaque: String = "42"
}
object Foo {
  val valueClass: Scope.MyClass = new Scope.MyClass
  val valueOpaque: Scope.MyOpaqueType = ("qwe").asInstanceOf[Scope.MyOpaqueType]
  val valueTypeAlias: Scope.MyTypeClass = ("qwe").asInstanceOf[Scope.MyTypeClass]
  valueClass.myExtensionForClass
  valueOpaque.myExtensionForOpaque
  //  valueTypeAlias.myExtensionForAlias
  trait A extends B
  trait B(implicit y: Int)
  new A with B()(1) {}
  class C extends A, B()(1)
}
