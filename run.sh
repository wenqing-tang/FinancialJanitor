#!/bin/bash

dir="$(cd "$(dirname "${0}")" && pwd)"
cd "${dir}/financialJanitor/src" && javac "Transaction.java" && java "Transaction" "${@}"
