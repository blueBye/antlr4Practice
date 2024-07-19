set windows-shell := ["powershell.exe",]

BASE_PATH := "./src/main/java/info/navidlabs"
PROJECT_PACKAGE := "info.navidlabs"

generate $base_path $project_package $grammar_package $grammar_name:
	antlr4 {{base_path}}/{{grammar_package}}/{{grammar_name}}.g4 -package {{project_package}}.{{grammar_package}}.gen -o {{base_path}}/{{grammar_package}}/gen

generate-visitor $base_path $project_package $grammar_package $grammar_name:
	antlr4 -visitor {{base_path}}/{{grammar_package}}/{{grammar_name}}.g4 -package {{project_package}}.{{grammar_package}}.gen -o {{base_path}}/{{grammar_package}}/gen

gen-L01:
	set GRAMMAR_PACKAGE "L01ExpresionLanguage"; \
	set GRAMMAR_NAME "Expr"; \
	just --justfile {{justfile()}} generate {{BASE_PATH}} {{PROJECT_PACKAGE}} $GRAMMAR_PACKAGE $GRAMMAR_NAME

gen-L02:
	set GRAMMAR_PACKAGE "L02LabeledExpressionLanguage"; \
	set GRAMMAR_NAME "LabeledExpr"; \
	just --justfile {{justfile()}} generate-visitor {{BASE_PATH}} {{PROJECT_PACKAGE}} $GRAMMAR_PACKAGE $GRAMMAR_NAME


#build: generate
#    javac -d . ./gen/*.java
#
#test-prog: build
#    javac  Expr*.java
#
#test-tokens: build
#    grun {{GRAMMAR}} {{GRAMMAR_ENTRY}} -tokens {{TEST_FILE}}
#
#test-gui: build
#    grun {{GRAMMAR}} {{GRAMMAR_ENTRY}} -gui {{TEST_FILE}}
#
#build-ts:
#    antlr4 {{GRAMMAR}}.g4 -o gen-typescript -Dlanguage=TypeScript
#
#clean-ps:
#    Get-ChildItem . | Where{$_.Name -Match "^gen$"} | Remove-Item -Recurse -Force -Confirm:$false
#    Get-ChildItem . | Where{$_.Name -Match "^{{GRAMMAR}}.*.class"} | Remove-Item -Force -Confirm:$false
