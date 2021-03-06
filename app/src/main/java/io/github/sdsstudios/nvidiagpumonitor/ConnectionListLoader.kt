package io.github.sdsstudios.nvidiagpumonitor

import android.content.Context
import android.database.Cursor
import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.CursorLoader
import android.support.v4.content.Loader
import com.sonelli.juicessh.pluginlibrary.PluginContract

/**
 * Created by Seth on 04/03/18.
 */

class ConnectionListLoader(private val mCtx: Context,
                           private val mLoaderFinishCallback: ConnectionListLoaderFinishedCallback
) : LoaderManager.LoaderCallbacks<Cursor> {

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
        return CursorLoader(
                mCtx,
                PluginContract.Connections.CONTENT_URI,
                PluginContract.Connections.PROJECTION,
                null, null,
                PluginContract.Connections.SORT_ORDER_DEFAULT
        )
    }

    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
        mLoaderFinishCallback.onLoaderFinished(data)
    }

    override fun onLoaderReset(loader: Loader<Cursor>) {
        mLoaderFinishCallback.onLoaderFinished(null)
    }
}