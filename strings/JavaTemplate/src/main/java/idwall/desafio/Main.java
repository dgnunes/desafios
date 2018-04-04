package idwall.desafio;

import idwall.desafio.string.IdwallFormatter;
import idwall.desafio.string.StringFormatter;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 */
public class Main {

    private static final String DEFAULT_INPUT_TEXT = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n" +
            "\n" +
            "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";
    
    private static final Integer DEFAULT_LIMIT = 40;
    private static final Boolean DEFAULT_JUSTIFY = true;

    public static void main(String[] args) {
        String text = DEFAULT_INPUT_TEXT;
        Integer limit = DEFAULT_LIMIT;
        Boolean justify = DEFAULT_JUSTIFY;
        switch (args.length) {
            case 1:
                text = args[0];
                break;
            case 2:
                text = args[0];
                limit = Integer.parseInt(args[1]);
                break;
            case 3:
                text = args[0];
                limit = Integer.parseInt(args[1]);
                justify = Boolean.parseBoolean(args[2]);
                break;
        }


        // Print input data
        System.out.println("Inputs: ");
        System.out.println("Text: " + text);
        System.out.println("Limit: " + limit);
        System.out.println("Should justify: " + justify);
        System.out.println("=========================");

        // Run IdwallFormatter
        final StringFormatter sf = new IdwallFormatter(limit, justify);
        String outputText = sf.format(text);
        
        // Print output text
        System.out.println("Output: ");
        System.out.println(outputText);     

        /* SECOND EXAMPLE
        String text2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis commodo neque sed ante ornare dignissim. Morbi ac sollicitudin ipsum. Vestibulum lobortis sollicitudin sapien et placerat. Curabitur semper pharetra nunc, non porta justo lobortis sit amet. Donec cursus volutpat tortor sit amet semper. Pellentesque a libero quis nibh rhoncus pretium. Suspendisse iaculis tincidunt lorem vitae porta. Duis non est eleifend, semper tellus id, sodales dolor.\n\nCurabitur gravida, elit in malesuada hendrerit, nisl mi malesuada erat, efficitur elementum metus purus nec risus. In hac habitasse platea dictumst. Fusce hendrerit ipsum sed imperdiet lacinia. Sed et maximus eros, eu placerat mauris. Vestibulum sapien elit, placerat vel orci quis, cursus aliquam dolor. Pellentesque venenatis libero purus, sit amet dictum velit molestie at. Nulla eget fringilla ante. Pellentesque pharetra justo erat, sit amet fringilla libero pulvinar non. Vivamus congue augue a ante auctor euismod. Pellentesque dictum sagittis nibh eu venenatis.\n\nDonec ac tempus eros. Curabitur commodo sit amet lectus ac molestie. Pellentesque efficitur enim eros, at blandit ipsum lobortis vitae. Sed sed sollicitudin sem, et fermentum risus. Duis iaculis egestas consequat. Duis ac ullamcorper nulla, in congue sem. Nam sed ex vehicula, congue est vel, semper nibh. Aliquam tempor tincidunt diam, vestibulum pellentesque sem pretium quis. Sed nulla turpis, rutrum vel risus et, sodales laoreet dui. Quisque velit dui, imperdiet ac risus at, dictum egestas tellus. Etiam dictum urna mollis ipsum consectetur, a luctus turpis posuere. Vivamus auctor vitae dui in laoreet. In elementum, mi eget pellentesque pretium, odio arcu suscipit elit, quis dignissim est est sit amet odio. Donec feugiat cursus nibh, quis finibus lorem.";

        // Print input data
        System.out.println("Inputs: ");
        System.out.println("Text: " + text2);
        System.out.println("Limit: " + limit);
        System.out.println("Should justify: " + justify);
        System.out.println("=========================");

        // Run IdwallFormatter
        outputText = sf.format(text2);
        
        // Print output text
        System.out.println("Output: ");
        System.out.println(outputText);
        */
    }
}
