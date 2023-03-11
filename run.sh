#!/bin/bash

dir="$(cd "$(dirname "${0}")" && pwd)"
cd "${dir}/financialJanitor/src" && javac "Application.java" && java "Application" "${@}"
