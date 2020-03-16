package com.panaceasoft.psstore.repository.common;

import androidx.lifecycle.LiveData;
import com.panaceasoft.psstore.AppExecutors;
import com.panaceasoft.psstore.Config;
import com.panaceasoft.psstore.api.PSApiService;
import com.panaceasoft.psstore.db.PSCoreDb;
import com.panaceasoft.psstore.utils.AbsentLiveData;
import com.panaceasoft.psstore.utils.Connectivity;
import com.panaceasoft.psstore.utils.RateLimiter;
import com.panaceasoft.psstore.utils.Utils;
import com.panaceasoft.psstore.viewobject.common.Resource;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

/**
 * Parent Class of All Repository Class in this project
 * Created by Panacea-Soft on 12/5/17.
 * Contact Email : teamps.is.cool@gmail.com
 */

public abstract class PSRepository {


    //region Variables

    protected final PSApiService psApiService;
    protected final AppExecutors appExecutors;
    protected final PSCoreDb db;
    @Inject
    protected Connectivity connectivity;
    protected RateLimiter<String> rateLimiter = new RateLimiter<>( Config.API_SERVICE_CACHE_LIMIT, TimeUnit.MINUTES);

    //endregion


    //region Constructor

    /**
     * Constructor of PSRepository
     * @param psApiService Panacea-Soft API Service Instance
     * @param appExecutors Executors Instance
     * @param db Panacea-Soft DB
     */
    protected PSRepository(PSApiService psApiService, AppExecutors appExecutors, PSCoreDb db) {
        Utils.psLog("Inside NewsRepository");
        this.psApiService = psApiService;
        this.appExecutors = appExecutors;
        this.db = db;
    }

    //endregion


    //region public Methods

    public LiveData<Resource<Boolean>> save(Object obj) {

        if(obj == null) {
            return AbsentLiveData.create();
        }

        SaveTask saveTask = new SaveTask(psApiService, db, obj);
        appExecutors.diskIO().execute(saveTask);
        return saveTask.getStatusLiveData();
    }


    public LiveData<Resource<Boolean>> delete(Object obj) {

        if(obj == null) {
            return AbsentLiveData.create();
        }

        DeleteTask deleteTask = new DeleteTask(psApiService, db, obj);
        appExecutors.diskIO().execute(deleteTask);
        return deleteTask.getStatusLiveData();
    }
    //endregion

}
