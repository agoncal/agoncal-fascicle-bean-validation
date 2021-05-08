# AGoncal Fascicle: Understanding Bean Validation 2.0

Code of my [Bean Validation Fascicle](https://agoncal.teachable.com/p/ebook-understanding-bean-validation).

![Travis](https://travis-ci.org/agoncal/agoncal-fascicle-bean-validation.svg?branch=2.0)

Validating data is a common task that Java developers have to do and it is spread throughout all layers (from client to database) of an application.
This common practice is time-consuming, error prone, and hard to maintain in the long run.
Besides, some of these constraints are so frequently used that they could be considered standard (checking for a null value, size, range, etc.).
It would be good to be able to centralise these constraints in one place and share them across layers.

That's when [Bean Validation](https://beanvalidation.org) comes into play.

In this [fascicle](https://agoncal.teachable.com/courses/category/ebook) will you will learn Bean Validation and use its different APIs to apply constraints on a bean, validate all sorts of constraints, write your own constraints and a few advanced topics such as integrating Bean Validation with other frameworks (JPA, JAX-RS, CDI, Spring).

![Bean Validation Fascicle](https://raw.githubusercontent.com/agoncal/agoncal-fascicle-bean-validation/master/cover.jpg)

Foreword by [Gunnar Morling](https://twitter.com/gunnarmorling)

> Exactly nine years ago, I received an email which would fundamentally change my professional life fundamentally.
<br/><br/>
> The sender was Emmanuel Bernard, spec lead of Bean Validation at that time, asking me whether I'd be interested in writing the documentation for the Bean Validation reference implementation.
I had published a few blog posts on Bean Validation and apparently Emmanuel liked them, so he offered me this job.
I felt honoured ("Wow, they read my blog?!"), excited ("Yeah, I'll become a famous open-source contributor!") but also a bit scared ("Hmm, can I even do that?").
Without thinking too long, I accepted the challenge and went off to write the first chapters of the Hibernate Validator reference documentation.
After a while, I sent in a patch file which was eventually committed to the SVN repository.
Boy, was I proud?!
<br/><br/>
> I had no idea that this would be the first step on my path to working full-time on open source and even becoming the Bean Validation spec lead myself one day.
But I had learned an important thing: thorough documentation, written in an easy-to-follow style is a vital factor for software to become successful.
The challenge lies in hitting the sweet spot of completeness (all the relevant features should be covered) and conciseness (the reader should be able to quickly find the information they're after).
The best functionality isn't worth much if potential users cannot easily find out about it.
<br/><br/>
> That's why I was immediately convinced of Antonio's idea of ripping apart his tremendously successful book on Java EE and extracting multiple, smaller fascicles out of it.
Each one focuses on one specific API, providing a gentle introduction to it as well as discussing more advanced topics at the same time.
It's with great joy that I see that the first of these fascicles is dedicated to Bean Validation.
<br/><br/>
> Based on his extensive experience of using Bean Validation in many Java EE and Spring based projects, Antonio did an outstanding job writing this fascicle.
Starting with the basics of putting data validation into the wider context of application development and of setting up your first Bean Validation application, the fascicle touches all the important aspects of Bean Validation such as using built-in and custom constraints, message interpolation, validation groups, method validation and much more.
A wide range of examples shows, in depth, how to use the API, and there's even detailed instructions for setting up your development environment, making it very easy to get started.
<br/><br/>
> Since I received that email from Emmanuel in February 2009, Bean Validation has come a long way.
Closely integrated with many other specifications and technologies such as JPA, JAX-RS, CDI, JavaFX or Spring, it's successfully used in countless projects.
Bean Validation 1.1 added the notion of method validation, making it trivial to automatically validate parameters and return values upon method invocation.
Bean Validation 2.0, released in 2017 and part of Java EE 8, brought closer integration with Java 8 and the long-awaited support for validating the elements of any generic container type.
How this is done?
<br/><br/>
Find out about this and much more by turning over and diving into this excellent fascicle!
<br/><br/>
**Gunnar Morling**  
_Spec Lead of Bean Validation 2.0 (JSR 380)_  
Hamburg, February 2018

And thanks to my proof-reader team:

* [Gunnar Morling](https://twitter.com/gunnarmorling)
* [Youness Teimouri](http://www.youness-teimouri.com)
* [Guillaume Smet](http://in.relation.to/guillaume-smet)
