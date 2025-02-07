package com.browser.core_browser.domain.repository

import android.graphics.Bitmap
import android.view.View.OnScrollChangeListener
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.browser.core_browser.domain.model.RedBrowserTab

/**
 * Repository interface for managing browser tabs and configuring associated [WebView] instances.
 *
 * This repository provides methods for configuring and controlling web views in browser tabs,
 * including loading URLs, customizing web view clients, and handling navigation events.
 */
interface RedBrowserRepository {

    /**
     * Configures the [WebView] settings for the given [RedBrowserTab].
     *
     * Sets JavaScript enabled, disables caching, clears history, and wipes the cache
     * for a fresh browsing session.
     *
     * @param tab The [RedBrowserTab] containing the [WebView] to configure.
     * @return The updated [RedBrowserTab] with configured [WebView] settings.
     */
    fun configureWebView(tab: RedBrowserTab): RedBrowserTab

    /**
     * Loads a URL in the specified [RedBrowserTab]'s [WebView].
     *
     * @param tab The [RedBrowserTab] containing the [WebView] where the URL will be loaded.
     */
    fun loadUrl(tab: RedBrowserTab)

    /**
     * Gets the [WebSettings] of the [WebView] in the specified [RedBrowserTab].
     *
     * [WebSettings] allow customization of web view features, including JavaScript support,
     * zoom controls, and caching.
     *
     * @param tab The [RedBrowserTab] containing the [WebView] whose settings are retrieved.
     * @return The [WebSettings] for the specified [WebView].
     */
    fun getWebViewSettings(tab: RedBrowserTab): WebSettings

    /**
     * Clears browsing data in the [WebView] of the specified [RedBrowserTab].
     *
     * Removes the web view's cache, history, and form data to provide a clean browsing state.
     *
     * @param tab The [RedBrowserTab] containing the [WebView] to clear data from.
     */
    fun clearWebViewData(tab: RedBrowserTab)

    /**
     * Sets a custom [WebViewClient] for handling web content events in the [WebView] of the specified [RedBrowserTab].
     *
     * @param tab The [RedBrowserTab] containing the [WebView] where the client is set.
     * @param client The [WebViewClient] to handle events like page loading and navigation.
     */
    fun setWebViewClient(tab: RedBrowserTab, client: WebViewClient)

    /**
     * Sets a custom [WebChromeClient] for handling UI events in the [WebView] of the specified [RedBrowserTab].
     *
     * The [WebChromeClient] manages events such as progress updates, title changes, and prompts.
     *
     * @param tab The [RedBrowserTab] containing the [WebView] where the client is set.
     * @param client The [WebChromeClient] to manage UI-related events in the web view.
     */
    fun setWebChromeClient(tab: RedBrowserTab, client: WebChromeClient)

    /**
     * Checks if the [WebView] in the specified [RedBrowserTab] can navigate back in its history.
     *
     * @param tab The [RedBrowserTab] containing the [WebView] to check for back navigation.
     * @return `true` if the web view can navigate back; otherwise, `false`.
     */
    fun canGoBack(tab: RedBrowserTab): Boolean

    /**
     * Navigates back in the history of the [WebView] in the specified [RedBrowserTab].
     *
     * @param tab The [RedBrowserTab] containing the [WebView] to navigate back.
     */
    fun goBack(tab: RedBrowserTab)

    /**
     * Checks if the [WebView] in the specified [RedBrowserTab] can navigate forward in its history.
     *
     * @param tab The [RedBrowserTab] containing the [WebView] to check for forward navigation.
     * @return `true` if the web view can navigate forward; otherwise, `false`.
     */
    fun canGoForward(tab: RedBrowserTab): Boolean

    /**
     * Navigates forward in the history of the [WebView] in the specified [RedBrowserTab].
     *
     * @param tab The [RedBrowserTab] containing the [WebView] to navigate forward.
     */
    fun goForward(tab: RedBrowserTab)

    /**
     * Reloads the current webpage within the specified browser tab.
     *
     * This function initiates a refresh for the webpage loaded in the `webView` component
     * of the provided [RedBrowserTab] instance, ensuring the latest content is displayed.
     * It can be called when the user requests to reload the page or when a connection error
     * has been resolved.
     *
     * @param tab The [RedBrowserTab] containing the `webView` component to be refreshed.
     */
    fun refreshWebPage(tab: RedBrowserTab)

    /**
     * Sets a listener to monitor scroll changes within the specified browser tab.
     *
     * This function attaches an [OnScrollChangeListener] to the `webView` component of the
     * given [RedBrowserTab] to observe and respond to scroll position changes. This is useful
     * for implementing effects like hiding the toolbar on scroll or triggering actions based on
     * specific scroll positions.
     *
     * @param tab The [RedBrowserTab] in which the scroll listener is to be set.
     * @param listener The [OnScrollChangeListener] instance to receive scroll change callbacks,
     * or `null` to remove any previously set listener.
     */
    fun setScrollChangeListener(tab: RedBrowserTab, listener: OnScrollChangeListener?)

}
