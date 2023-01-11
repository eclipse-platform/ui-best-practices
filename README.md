Eclipse UI Best Practices
=========================

Welcome to the Eclipse UI Best Practices repository. 
This repository provides useful information for developers of the Eclipse IDE and Eclipse Plug-Ins.
Our [Eclipse UI Guidelines](eclipse_ui_guidelines.adoc) describe guidelines for  Eclipse Plug-In developers. 
Please do not hesitate to give feedback and send send improvement suggestions via pull requests.



Feedback & Contact
------------------

We'd like to hear your feedback. It really matters to us! 

There are several ways to submit feedback:
* Submit an [issue](https://github.com/eclipse-platform/ui-best-practices/issues), or
* Submit a [pull request](https://github.com/eclipse-platform/ui-best-practices/pulls) 
* Start a [discussion](https://github.com/eclipse-platform/ui-best-practices/discussions)

If you submit a PR, please read 'contributing' below)

Content
-------

See [Github pages](https://eclipse-platform.github.io/ui-best-practices/) for the current content.

Contributing
------------

This directory contains the source for the [Eclipse UI Guidelines](eclipse_ui_guidelines.adoc)
in AsciiDoc format, the build script, and generated output. The build script is
configured to generate output for a specific version of the document and running
the build (`make`) may overwrite any existing document.

The output files (eg., `*.html`) may be live documents that may be included by
other documents found in the repository and also externally, so take care with
what you commit.

### Installing Asciidoctor
Asciidoctor is required for generating the output files. Please have a look at
[Installing Asciidoctor Toolchain](http://asciidoctor.org/docs/install-toolchain/)
or [Installing Asciidoctor on OS X](http://asciidoctor.org/docs/install-asciidoctor-osx/).
For PDF generartion you also need to install
[Asciidoctor PDF Support](http://asciidoctor.org/docs/convert-asciidoc-to-pdf/).

### AsciiDoc Syntax
Please refere to 
[AsciiDoc Syntax Quick Reference](http://asciidoctor.org/docs/asciidoc-syntax-quick-reference/).

### Making changes

Ensure that every sentence is in one line.
This is the so-called _One sentence per line_ best practice from Asciidoc, see https://asciidoctor.org/docs/asciidoc-recommended-practices/#one-sentence-per-line for details. 



### Update Process
Please submit pull requests for any proposals/semantic changes/enhancements.
We'll use pull requests for discussing them.

Requirements, ideas and todos should be captured in issues and should be referenced
in pull requests addressing them.

A note for committers: spelling, grammatical as well as cosmetical corrections
don't require a pull request.
