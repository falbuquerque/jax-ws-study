package falbuquerque.study.ws.amazon.client;

import java.util.concurrent.ExecutionException;

import falbuquerque.study.ws.amazon.client.generated.AWSECommerceService;
import falbuquerque.study.ws.amazon.client.generated.AWSECommerceServicePortType;
import falbuquerque.study.ws.amazon.client.generated.ItemSearch;
import falbuquerque.study.ws.amazon.client.generated.ItemSearchRequest;

public class AmazonClient {

    public static void main(String[] args) {
        final String accessKey = "?"; // TODO get the key. Actually I can't because of my zip code
        final AWSECommerceService service = new AWSECommerceService();
        final AWSECommerceServicePortType port = service.getAWSECommerceServicePort();
        final ItemSearchRequest request = new ItemSearchRequest();
        request.setSearchIndex("Books");
        request.setKeywords("quantum gravity");

        final ItemSearch search = new ItemSearch();
        search.getRequest().add(request);
        search.setAWSAccessKeyId(accessKey);
        
        // Wrapped
//        final Holder<List<Items>> items = new Holder<>();
//        port.itemSearch(search.getMarketplaceDomain(), search.getAWSAccessKeyId(), search.getAssociateTag(),
//                search.getXMLEscaping(), search.getValidate(), search.getShared(), search.getRequest(), null, items);
//        items.value.get(0).getItem().forEach(item -> System.out.println(item.getItemAttributes().getTitle()));
        
        // Unwrapped - Sync
//        port.itemSearch(search).getItems().forEach(item -> {
//            item.getItem().forEach(innerItem -> System.out.println(innerItem.getItemAttributes().getTitle()));
//        });
        
        // Async
        port.itemSearchAsync(search, future -> {

            try {
                future.get().getItems().forEach(item -> {
                    item.getItem().forEach(innerItem -> System.out.println(innerItem.getItemAttributes().getTitle()));
                });
            } catch (final InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

        });
        
        try {
            Thread.sleep(10000);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}
