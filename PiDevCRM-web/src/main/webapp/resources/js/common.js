    var currentAmount = 0;

    $(document).ready(function () {
        if (false)
            $("#ctl00_ctl38_g_4152195b_7a6c_44c1_88ea_8f9137eb07d1_ctl00_txtCaptcha").realperson({ chars: $.realperson.alphanumeric, length: 6 });
    });

    var prm = Sys.WebForms.PageRequestManager.getInstance();
    prm.add_endRequest(rebindEvent);
    function rebindEvent() {
        if (false)
            $("#ctl00_ctl38_g_4152195b_7a6c_44c1_88ea_8f9137eb07d1_ctl00_txtCaptcha").realperson({ chars: $.realperson.alphanumeric, length: 6 });
    }    

    function doIncrement() {
        var $button = $(this);
        var oldValue = $('#txtAmount').val();
        var newVal = parseFloat(oldValue) + 1;
     
            $('#txtAmount').val(newVal);
            currentAmount = newVal;
       
        viewVolumeData();
    } 

    function doDecrement() {
        var $button = $(this);
        var oldValue = $('#txtAmount').val();
        
            var newVal = parseFloat(oldValue) - 1;
      
        $('#txtAmount').val(newVal);
        currentAmount = newVal;
        viewVolumeData();
    } 

    function viewVolumeData() {
        var newValue = $('#txtAmount').val();               
        var VolumeData="";
        switch(newValue) {
            case "1":
                VolumeData = "200" ;
                break;
            case "2":
                VolumeData = "400" ;
                break;
            case "3":
                VolumeData = "600" ;
                break;
            case "4":
                VolumeData = "800" ;
                break;
            case "5":
                VolumeData = "1122" ;
                break;
            case "6":
                VolumeData = "1347" ;
                break;
            case "7":
                VolumeData = "1571" ;
                break;
            case "8":
                VolumeData = "1796" ;
                break;
            case "9":
                VolumeData = "2309" ;
                break;
            case "10":
                VolumeData = "2565" ;
                break;
            case "11":
                VolumeData = "3292" ;
                break;
            case "12":
                VolumeData = "3592" ;
                break;
            case "13":
                VolumeData = "3891" ;
                break;
            case "14":
                VolumeData = "4190" ;
                break;
            case "15":
                VolumeData = "4490" ;
                break;
            case "16":
                VolumeData = "5747" ;
                break;
            case "17":
                VolumeData = "6106" ;
                break;
            case "18":
                VolumeData = "6465" ;
                break;
            case "19":
                VolumeData = "6825" ;
                break;
            case "20":
                VolumeData = "8980" ;
                break;
            case "21":
                VolumeData = "9429" ;
                break;
            case "22":
                VolumeData = "9878" ;
                break;
            case "23":
                VolumeData = "10327" ;
                break;
            case "24":
                VolumeData = "10776" ;
                break;
            case "25":
                VolumeData = "22451" ;
                break;
            case "26":
                VolumeData = "23349" ;
                break;
            case "27":
                VolumeData = "24247" ;
                break;
            case "28":
                VolumeData = "25145" ;
                break;
            case "29":
                VolumeData = "26043" ;
                break;
            case "30":
                VolumeData = "26941" ;
                break;
            case "31":
                VolumeData = "27839" ;
                break;
            case "32":
                VolumeData = "28737" ;
                break;
            case "33":
                VolumeData = "29635" ;
                break;
            case "34":
                VolumeData = "30533" ;
                break;
            case "35":
                VolumeData = "31431" ;
                break;
            case "36":
                VolumeData = "32329" ;
                break;
            case "37":
                VolumeData = "33227" ;
                break;
            case "38":
                VolumeData = "34125" ;
                break;
            case "39":
                VolumeData = "35023" ;
                break;
            case "40":
                VolumeData = "35921" ;
                break;
            case "41":
                VolumeData = "36820" ;
                break;
            case "42":
                VolumeData = "39703" ;
                break;
            case "43":
                VolumeData = "40648" ;
                break;
            case "44":
                VolumeData = "41593" ;
                break;
            case "45":
                VolumeData = "42539" ;
                break;
            case "46":
                VolumeData = "43484" ;
                break;
            case "47":
                VolumeData = "44429" ;
                break;
            case "48":
                VolumeData = "45375" ;
                break;
            case "49":
                VolumeData = "46320" ;
                break;
            case "50":
                VolumeData = "47265" ;
                break;           
            default:
                // code block
        }
        var myHiddenDataVolume = document.getElementById('ctl00_ctl38_g_4152195b_7a6c_44c1_88ea_8f9137eb07d1_ctl00_hdnfldVariable');
        myHiddenDataVolume.value = VolumeData;
        $('#txtVolumeData').val(VolumeData);
    }

    function verifAmount() {

        var newValue = parseFloat($('#txtAmount').val());
        
        if(!isNaN($('#txtAmount').val()))
        {
            if(newValue > 50)
            {
                currentAmount = 50;
                $('#txtAmount').val(currentAmount);
            }
    
            else
            {
                $('#txtAmount').val(currentAmount);
            }
        }
        else
        {
            $('#txtAmount').val(currentAmount);
        }
        viewVolumeData();
    }