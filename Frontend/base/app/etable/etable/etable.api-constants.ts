import { EtableBase} from '@baseapp/etable/etable/etable.base.model';

export class EtableApiConstants {
    public static readonly create: any = {
        url: '/rest/etables/',
        method: 'POST',
        showloading: true
    };
    public static readonly delete: any = {
        url: '/rest/etables/{ids}',
        method: 'DELETE',
        showloading: true
    };
    public static readonly autoSuggestService: any = {
        url: '/rest/etables/autosuggest',
        method: 'GET',
        showloading: true
    };
    public static readonly getDatatableData: any = {
        url: '/rest/etables/datatable',
        method: 'POST',
        showloading: true
    };
    public static readonly getById: any = {
        url: '/rest/etables/{sid}',
        method: 'GET',
        showloading: true
    };
    public static readonly update: any = {
        url: '/rest/etables/',
        method: 'PUT',
        showloading: true
    };
}