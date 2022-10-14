
clean:
	make -C app clean

build:
	make -C app clean build

install:
	make -C app clean install

run-dist:
	./build/install/app/bin/app

run:
	make -C app clean
	make -C app run

test:
	make -C app test

lint:
	make -C app checkstyleMain checkstyleTest

report:
	make -C app jacocoTestReport

wrapper:
	make -C app wrapper

build-run: build run

.PHONY: build