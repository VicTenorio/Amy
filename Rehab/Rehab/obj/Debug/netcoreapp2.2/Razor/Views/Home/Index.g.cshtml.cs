#pragma checksum "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "5f31dd66a022f96bd7d2b92cb5308c8caec42351"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Home_Index), @"mvc.1.0.view", @"/Views/Home/Index.cshtml")]
[assembly:global::Microsoft.AspNetCore.Mvc.Razor.Compilation.RazorViewAttribute(@"/Views/Home/Index.cshtml", typeof(AspNetCore.Views_Home_Index))]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
#line 1 "C:\Workspace\Amy\Rehab\Rehab\Views\_ViewImports.cshtml"
using Rehab;

#line default
#line hidden
#line 2 "C:\Workspace\Amy\Rehab\Rehab\Views\_ViewImports.cshtml"
using Rehab.Models;

#line default
#line hidden
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"5f31dd66a022f96bd7d2b92cb5308c8caec42351", @"/Views/Home/Index.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"a83336bfd99b0d2094e983f52cedfb8a61519833", @"/Views/_ViewImports.cshtml")]
    public class Views_Home_Index : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<Rehab.Models.HomeViewModel>
    {
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_0 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("rel", new global::Microsoft.AspNetCore.Html.HtmlString("stylesheet"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_1 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("type", new global::Microsoft.AspNetCore.Html.HtmlString("text/css"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_2 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("href", new global::Microsoft.AspNetCore.Html.HtmlString("~/css/home.css"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_3 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("type", new global::Microsoft.AspNetCore.Html.HtmlString("text/javascript"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_4 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("src", new global::Microsoft.AspNetCore.Html.HtmlString("~/js/home.js"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        #line hidden
        #pragma warning disable 0169
        private string __tagHelperStringValueBuffer;
        #pragma warning restore 0169
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperExecutionContext __tagHelperExecutionContext;
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner __tagHelperRunner = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner();
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __backed__tagHelperScopeManager = null;
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __tagHelperScopeManager
        {
            get
            {
                if (__backed__tagHelperScopeManager == null)
                {
                    __backed__tagHelperScopeManager = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager(StartTagHelperWritingScope, EndTagHelperWritingScope);
                }
                return __backed__tagHelperScopeManager;
            }
        }
        private global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper;
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
#line 1 "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml"
  
    ViewData["Title"] = "Entrar";
    

#line default
#line hidden
            BeginContext(82, 61, false);
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("link", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagOnly, "5f31dd66a022f96bd7d2b92cb5308c8caec423514916", async() => {
            }
            );
            __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_0);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_1);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_2);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            EndContext();
            BeginContext(143, 65, true);
            WriteLiteral("\r\n<div class=\"text-center\">\r\n    <h1 class=\"display-4\">Bem Vindo ");
            EndContext();
            BeginContext(209, 14, false);
#line 7 "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml"
                               Write(Model.userName);

#line default
#line hidden
            EndContext();
            BeginContext(223, 703, true);
            WriteLiteral(@"</h1>
    <p>Estes são os usuario que desejam prestar serviços:<a />.</p>

    <div id=""carouselExampleControls"" class=""carousel slide"" data-ride=""carousel"">

        <table class=""table"">
            <thead>
                <tr>
                    <th scope=""col"">Id</th>
                    <th scope=""col"">Nome</th>
                    <th scope=""col"">Email</th>
                    <th scope=""col"">RG</th>
                    <th scope=""col"">CPF OU CNPJ</th>
                    <th scope=""col"">Data de Envio</th>
                    <th scope=""col"">Documento</th>
                    <th scope=""col"">Aprovar</th>

                </tr>
            </thead>
            <tbody>
");
            EndContext();
#line 27 "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml"
                 foreach (UserDocumentImageViewModel image in Model.imagesToBeEvalueted)
                {

#line default
#line hidden
            BeginContext(1035, 23, true);
            WriteLiteral("                    <tr");
            EndContext();
            BeginWriteAttribute("id", " id=\"", 1058, "\"", 1072, 1);
#line 29 "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml"
WriteAttributeValue("", 1063, image.Id, 1063, 9, false);

#line default
#line hidden
            EndWriteAttribute();
            BeginContext(1073, 43, true);
            WriteLiteral(">\r\n                        <th scope=\"row\">");
            EndContext();
            BeginContext(1117, 12, false);
#line 30 "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml"
                                   Write(image.IdUser);

#line default
#line hidden
            EndContext();
            BeginContext(1129, 35, true);
            WriteLiteral("</th>\r\n                        <td>");
            EndContext();
            BeginContext(1165, 15, false);
#line 31 "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml"
                       Write(image.User.Name);

#line default
#line hidden
            EndContext();
            BeginContext(1180, 35, true);
            WriteLiteral("</td>\r\n                        <td>");
            EndContext();
            BeginContext(1216, 16, false);
#line 32 "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml"
                       Write(image.User.Email);

#line default
#line hidden
            EndContext();
            BeginContext(1232, 35, true);
            WriteLiteral("</td>\r\n                        <td>");
            EndContext();
            BeginContext(1268, 13, false);
#line 33 "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml"
                       Write(image.User.RG);

#line default
#line hidden
            EndContext();
            BeginContext(1281, 35, true);
            WriteLiteral("</td>\r\n                        <td>");
            EndContext();
            BeginContext(1317, 18, false);
#line 34 "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml"
                       Write(image.User.cpfCnpj);

#line default
#line hidden
            EndContext();
            BeginContext(1335, 35, true);
            WriteLiteral("</td>\r\n                        <td>");
            EndContext();
            BeginContext(1371, 18, false);
#line 35 "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml"
                       Write(image.UploadedDate);

#line default
#line hidden
            EndContext();
            BeginContext(1389, 69, true);
            WriteLiteral("</td>\r\n                        <td class=\"table-container-image\"><img");
            EndContext();
            BeginWriteAttribute("onclick", " onclick=\"", 1458, "\"", 1495, 3);
            WriteAttributeValue("", 1468, "showModal(\'", 1468, 11, true);
#line 36 "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml"
WriteAttributeValue("", 1479, image.User.RG, 1479, 14, false);

#line default
#line hidden
            WriteAttributeValue("", 1493, "\')", 1493, 2, true);
            EndWriteAttribute();
            BeginWriteAttribute("id", " id=\"", 1496, "\"", 1515, 1);
#line 36 "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml"
WriteAttributeValue("", 1501, image.User.RG, 1501, 14, false);

#line default
#line hidden
            EndWriteAttribute();
            BeginContext(1516, 20, true);
            WriteLiteral(" class=\"table-image\"");
            EndContext();
            BeginWriteAttribute("alt", " alt=\"", 1536, "\"", 1558, 1);
#line 36 "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml"
WriteAttributeValue("", 1542, image.User.Name, 1542, 16, false);

#line default
#line hidden
            EndWriteAttribute();
            BeginWriteAttribute("src", " src=\"", 1559, "\"", 1629, 1);
#line 36 "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml"
WriteAttributeValue("", 1565, "data:image/jpeg;base64,"+Convert.ToBase64String(image.Image), 1565, 64, false);

#line default
#line hidden
            EndWriteAttribute();
            BeginContext(1630, 93, true);
            WriteLiteral("></td>\r\n                        <td class=\"text-center\">\r\n                            <button");
            EndContext();
            BeginWriteAttribute("onclick", " onclick=\"", 1723, "\"", 1752, 3);
            WriteAttributeValue("", 1733, "Aprove(\'", 1733, 8, true);
#line 38 "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml"
WriteAttributeValue("", 1741, image.Id, 1741, 9, false);

#line default
#line hidden
            WriteAttributeValue("", 1750, "\')", 1750, 2, true);
            EndWriteAttribute();
            BeginContext(1753, 96, true);
            WriteLiteral(" class=\"btn btn-primary avaliation-buttom\">Aprovar</button>\r\n                            <button");
            EndContext();
            BeginWriteAttribute("onclick", " onclick=\"", 1849, "\"", 1878, 3);
            WriteAttributeValue("", 1859, "Negate(\'", 1859, 8, true);
#line 39 "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml"
WriteAttributeValue("", 1867, image.Id, 1867, 9, false);

#line default
#line hidden
            WriteAttributeValue("", 1876, "\')", 1876, 2, true);
            EndWriteAttribute();
            BeginContext(1879, 116, true);
            WriteLiteral(" class=\"btn btn-danger avaliation-buttom\">Negar</button>\r\n                        </td>\r\n                    </tr>\r\n");
            EndContext();
#line 42 "C:\Workspace\Amy\Rehab\Rehab\Views\Home\Index.cshtml"
                }

#line default
#line hidden
            BeginContext(2014, 236, true);
            WriteLiteral("            </tbody>\r\n        </table>\r\n    </div>\r\n\r\n    <div id=\"myModal\" class=\"modal\">\r\n        <span class=\"close\">&times;</span>\r\n        <img class=\"modal-content\" id=\"img01\">\r\n        <div id=\"caption\"></div>\r\n    </div>\r\n\r\n    ");
            EndContext();
            BeginContext(2250, 59, false);
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("script", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "5f31dd66a022f96bd7d2b92cb5308c8caec4235113591", async() => {
            }
            );
            __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_3);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_4);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            EndContext();
            BeginContext(2309, 2, true);
            WriteLiteral("\r\n");
            EndContext();
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<Rehab.Models.HomeViewModel> Html { get; private set; }
    }
}
#pragma warning restore 1591
