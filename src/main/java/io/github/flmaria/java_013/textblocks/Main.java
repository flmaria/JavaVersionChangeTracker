package io.github.flmaria.java_013.textblocks;

public class Main {

    public static void main(String[] args) {

        /**
         * Text Blocks allow developers to define string literals that span multiple lines, making the code more readable.
         *
         * - Newlines are automatically included in the string, so developers don't need to manually add \n.
         *  - Special characters like double quotes inside the text block don’t need to be escaped. For instance, you can include " within a Text Block without needing to escape it.
         *  - Text Blocks are useful for embedding JSON, XML, HTML, SQL, or any other content where multi-line strings are common. This improves both the readability and maintainability of the code.
         */

        String jsonString = """
                    {
                        "name": "John Doe",
                        "age": 30,
                        "city": "New York"
                    }
                    """;

        String html = """
              <html>
                  <body>
                      <p>"Hello, World!"</p>
                  </body>
              </html>
              """;

        //The placement of the closing triple quotes defines whether the final newline in the Text Block is included in the string.
        // If the closing triple quotes are aligned with the text, the newline before them is included; otherwise, it’s excluded.

        String block = """
               Line 1
               Line 2
               """;  // Final newline is included

        String blockNoNewline = """
                        Line 1
                        Line 2""";  // Final newline is excluded

        //stripIndent() - method is used to remove common leading whitespace from all lines in a Text Block.
        // This is useful when you want the content to be indented in your source code for readability but want to remove that indentation in the actual string

        String textBlock = """
                 This is line 1
                    This is line 2
                 This is line 3
                """;

        System.out.println("Before stripIndent():");
        System.out.println(textBlock);

        String strippedTextBlock = textBlock.stripIndent();

        System.out.println("\nAfter stripIndent():");
        System.out.println(strippedTextBlock);

        //translateEscapes() - method interprets escape sequences within a Text Block.
        // This can be helpful when you want to include escape sequences like \n, \t, etc., in the Text Block, but you want them to be processed (translated) rather than displayed as plain text.

        String textBlock2 = """
                Line 1\\n
                Line 2\\tTabbed
                Line 3
                """;

        System.out.println("Before translateEscapes():");
        System.out.println(textBlock2);

        String translatedTextBlock = textBlock2.translateEscapes();

        System.out.println("\nAfter translateEscapes():");
        System.out.println(translatedTextBlock);




    }

}
