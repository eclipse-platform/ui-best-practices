Eclipse UI Best Practices
=========================

Welcome to the information hub for Eclipse UI Best Practices. This repository provides
usefuly information for developers of the Eclipse IDE and Eclipse Plug-Ins.


Eclipse UI Guidelines
---------------------

Our [Eclipse UI Guidelines](eclipse_ui_guidelines.adoc) are the go-to source of truth
for Eclipse Plug-In developers. Please make yourself familar and don't hesitate to
give feedback.


Feedback & Contact
------------------

Do you like the Eclipse UI Guildines or is there something you don't like?
We are a group of Eclipse UI enthusiasts with a variety of opinions.
Occasionally we do produce good results. Most of the time there is room for improvement.

We'd like to hear your feedback. It really matters to us! There are several ways
to submit feedback:
* Send an email to [our mailing list](https://dev.eclipse.org/mailman/listinfo/ui-best-practices-working-group)
* Submit an issue
* Submit a pull request


Contributing
------------

This directory contains the source for the [Eclipse UI Guidelines](eclipse_ui_guidelines.adoc)
in AsciiDoc format, the build script, and generated output.

Note that the build script is configured to generate output for a specific version
of the document and running the build may overwrite any existing document.

The output files (*.html) may be live documents that may be included by other documents
found in the repository and also externally, so take care with what you commit.

### Installing Asciidoctor
Asciidoctor is required for generating the output files. Please have a look at
[Installing Asciidoctor Toolchain](http://asciidoctor.org/docs/install-toolchain/)
or [Installing Asciidoctor on OS X](http://asciidoctor.org/docs/install-asciidoctor-osx/).

For PDF generartion you also need to install
[Asciidoctor PDF Support](http://asciidoctor.org/docs/convert-asciidoc-to-pdf/).

### Making changes
Ensure that lines in .adoc files are *hard wrapped* at 80 columns. This makes it
much easier to view the diffs in git. How you do this depends on your particular
text editor.

As a sanity check, please copy the `scripts/githooks/pre-commit` file over to your
`.git/hooks` folder. The script will run automatically before you make a commit
and warn you if you have lines longer than 80 characters.

Sometimes, it is *not* possible to break at 80 columns, e.g., because you have a
URL that cannot be split across lines. In that case, you can use `git commit
--no-verify` to temporarily bypass the check.

### Update Process
Please submit pull requests for any proposals/semantic changes/enhancements.
We'll use pull requests for discussing them.

A note for committers: spelling, grammatical as well as cosmetical corrections
don't require a pull request.
