package domain

import data.MakeUPAPI
import data.model.MakeUpItem
import kotlinx.coroutines.coroutineScope
import platform.Logger

private const val TAG = "GetFeedData"

class GetFeedData {
    public suspend fun invokeGetMyMakeUpData(


        onSuccess: (List<MakeUpItem>) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        try {
            val result = MakeUPAPI.fetchMakeUPData("products.json")

            Logger.d(TAG, "invokeFetchRWEntry ")
            /*val xml = Xml.parse(result.bodyAsText())

        val feed = mutableListOf<MakUpItem>()
        for (node in xml.allNodeChildren) {
            val parsed = parseNode(platform, node)

            if (parsed != null) {
                feed += parsed
            }
        }*/

            coroutineScope {
                onSuccess(result)
            }
        } catch (e: Exception) {
            Logger.e(TAG, "Unable to fetch feed:")
            coroutineScope {
                onFailure(e)
            }
        }

    }
}