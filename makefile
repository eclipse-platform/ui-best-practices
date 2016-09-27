.PHONY: \
	eclipse_ui_guidelines.html \
	eclipse_ui_guidelines.pdf

all: \
	eclipse_ui_guidelines.html \
	eclipse_ui_guidelines.pdf

eclipse_ui_guidelines.html: eclipse_ui_guidelines.adoc
	asciidoctor -a version=v4 -a hide-uri-scheme -b html5 -d article -o eclipse_ui_guidelines.html eclipse_ui_guidelines.adoc

eclipse_ui_guidelines.pdf: eclipse_ui_guidelines.adoc
	asciidoctor -a version=v4 -a hide-uri-scheme -r asciidoctor-pdf -b pdf -d article -o eclipse_ui_guidelines.pdf eclipse_ui_guidelines.adoc