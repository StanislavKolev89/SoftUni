import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder builder = new StringBuilder();
        for (String url : urls) {
            if (OnlyCharacters(url)) {
                builder.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());
            } else {
                builder.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return builder.toString().trim();
    }

    private boolean OnlyCharacters(String url) {
        for (int i = 0; i < url.length(); i++) {
            char ch = url.charAt(i);
            if(Character.isDigit(ch)){
                return false;
            }
        }
        return true;
    }


    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();
        for (String number : numbers) {
            if (onlyDigits(number)) {
                builder.append(String.format("Calling... %s", number)).append(System.lineSeparator());
            } else {
                builder.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return builder.toString().trim();
    }

    private boolean onlyDigits(String number) {
        boolean isDigits;
        try {
            int n = Integer.parseInt(number);
            isDigits = true;
        } catch (IllegalArgumentException e) {
            isDigits = false;
        }
        return isDigits;
    }

}
