package com.spark;

import static spark.Spark.get;

public class HelloSpark {

    public static void main(String[] args) {
        get("/", (req, res) -> {
            return "Hello Spark, next step: Cloudant.";
        });
    }
}
