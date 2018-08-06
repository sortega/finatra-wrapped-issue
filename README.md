# Simple project demonstrating serialization issues with `Wrapped[_]`

You can serialize wrapped primitives by extending the universal trait `Wrapped[_]` but you cannot
deserialize them back. You get:

```
18:09:28.451 [finagle/netty4-2] ERROR com.twitter.finatra.http.internal.exceptions.ThrowableExceptionMapper - Unhandled Exception
java.lang.IllegalArgumentException: argument type mismatch
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
	at com.twitter.finatra.json.internal.caseclass.jackson.FinatraCaseClassDeserializer.create(FinatraCaseClassDeserializer.scala:220)
	at com.twitter.finatra.json.internal.caseclass.jackson.FinatraCaseClassDeserializer.createAndValidate(FinatraCaseClassDeserializer.scala:213)

```
