// API testing in service now
// 1.Endpoints
// 2.Authorization
// 3.Headers
// 4.Body
// 5.CURD options

import {request, test} from "@playwright/test" 

 let id: any // Globaly declaring

 test.describe.serial(`Service_Now`,async()=>{

 
test(`Creating incident in service now, using PW with API`, async({request})=>{

  const response=  await request.post(`https://dev293043.service-now.com/api/now/table/incident`,
    {
        headers:{
            "Authorization": "Basic YWRtaW46b0dVVzZpd2czPVA9",
            "Content-Type":"application/json"
        },
        data:{
            "short_description": "Lpatop and network issue for Sai through PostMan API CALL- Sai"
        }
    }
    )
const responseBoday = await response.json()
console.log(responseBoday)
    console.log(response.status)
    console.log(response.statusText)

     id = responseBoday.result.sys_id
     console.log(id);
})

test(`Fetching the created incident details`, async({request})=>{

     const Fetching=  await request.get(`https://dev293043.service-now.com/api/now/table/incident/${id}`,

        {
            headers:{
             "Authorization": "Basic YWRtaW46b0dVVzZpd2czPVA9",
             "Content-Type":"application/json"

            }
        }

    )
    const inc= await Fetching.json()
    console.log(inc)

})

test(`updating the details`, async({request})=>{

    const patch =await request.patch(`https://dev293043.service-now.com/api/now/table/incident/${id}`,

        {
            headers:{
            "Authorization": "Basic YWRtaW46b0dVVzZpd2czPVA9",
             "Content-Type":"application/json"

            },
            data:{
                 "short_description":"Lpatop and network issue for Sai through PostMan Has been resolved call on 9100014447- Sai"
            }

        }


    )
    const patch_Result= await patch.json()
    console.log(patch_Result)
    
})
test(`Delete the incident`, async({request})=>{

    const del=await request.delete(`https://dev293043.service-now.com/api/now/table/incident/${id}`,{

        headers:{
   "Authorization": "Basic YWRtaW46b0dVVzZpd2czPVA9",
             "Content-Type":"application/json"

        }
    }
        
    )
//    const del_resonse= await del.json()
//    console.log(del_resonse)
})
 
})

