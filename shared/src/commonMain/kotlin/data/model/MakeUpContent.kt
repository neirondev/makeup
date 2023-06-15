package data.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductColor (
    var hex_value: String? = null,
    var colour_name: String? = null
)

@Serializable
data class MakeUpItem  (
   // @SerialName("id")
    var id:Int? = 0,
   // @SerialName("brand")
    var brand: String? = null,
    var name: String? = null,
    var price: String? = null,
    var price_sign: String? = null,
    var currency: String? = null,
    var image_link: String? = null,
    var product_link: String? = null,
    var website_link: String? = null,
    var description: String? = null,
    var rating:Double? = 0.0,
    var category: String? = null,
    var product_type: String? = null,
    var tag_list: List<String>? = null,
    var created_at: String? = null,//Data
    var updated_at: String? = null,//Data
    var product_api_url: String? = null,
    var api_featured_image: String? = null,
    var product_colors: List<ProductColor>? = null
 )