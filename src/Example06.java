import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class Example06 {
    public static void main(String[] args) {
        // https://raw.githubusercontent.com/kimjava911/251029_java_adv/refs/heads/main/secret.txt
        String url = "https://raw.githubusercontent.com/kimjava911/251029_java_adv/refs/heads/main/secret.txt";
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        Path destination = Path.of("my_secret.txt");
        try {
            HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(destination));
            System.out.println("파일 다운로드 완료 : " + response.body());
//        } catch (IOException e) {
//        } catch (InterruptedException e) {
//        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String imgUrl = "https://images.unsplash.com/photo-1592194996308-7b43878e84a6?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&q=80&w=1887";
        HttpRequest imgRequest = HttpRequest.newBuilder()
                .uri(URI.create(imgUrl))
                .build();
        Path imgDestination = Path.of("my_cat.png");
        try {
            HttpResponse<Path> response = client.send(imgRequest, HttpResponse.BodyHandlers.ofFile(imgDestination));
            System.out.println("파일 다운로드 완료 : " + response.body());
//        } catch (IOException e) {
//        } catch (InterruptedException e) {
//        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
