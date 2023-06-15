package sourse




//http://makeup-api.herokuapp.com/api/v1/products.json

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root[] root = om.readValue(myJsonString, Root[].class); */
class ProductColor {
    var hex_value: String? = null
    var colour_name: String? = null
}

class Root {
    var id = 0
    var brand: String? = null
    var name: String? = null
    var price: String? = null
    var price_sign: String? = null
    var currency: String? = null
    var image_link: String? = null
    var product_link: String? = null
    var website_link: String? = null
    var description: String? = null
    var rating = 0.0
    var category: String? = null
    var product_type: String? = null
    var tag_list: List<String>? = null
    var created_at: String? = null//Data
    var updated_at: String? = null//Data
    var product_api_url: String? = null
    var api_featured_image: String? = null
    var product_colors: List<ProductColor>? = null
}
//http://makeup-api.herokuapp.com/api/v1/products.json?brand=covergirl&product_type=lipstick


