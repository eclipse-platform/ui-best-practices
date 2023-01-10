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
Ensure that lines in `.adoc` files are *hard wrapped* at 80 columns. This makes it
much easier to view the diffs in git. How you do this depends on your particular
text editor.

As a sanity check, please install the Git hooks contained in this repository
by running `bin/git/install-hooks`. The pre-commit hook script will run 
automatically before you make a commit and warn you if you have lines longer 
than 80 characters.

Sometimes, it is *not* possible to break at 80 columns, e.g., because you have a
URL that cannot be split across lines. In that case, you can use `git commit
--no-verify` to temporarily bypass the check.

### Update Process
Please submit pull requests for any proposals/semantic changes/enhancements.
We'll use pull requests for discussing them.

Requirements, ideas and todos should be captured in issues and should be referenced
in pull requests addressing them.

A note for committers: spelling, grammatical as well as cosmetical corrections
don't require a pull request.
