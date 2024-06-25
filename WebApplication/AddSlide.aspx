<%@ Page Title="" Language="vb" AutoEventWireup="false" MasterPageFile="~/Site2.Master" CodeBehind="AddSlide.aspx.vb" Inherits="WebApplication1.WebForm6" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="conMain" runat="server">
      <h3 style="color: blue">Add Slides</h3>
    <div class="form-group">
                                    <label style="color: black" class="col-md-12">Upload Image</label>
                                    <div class="col-md-12">
                                        <asp:FileUpload ID="FileUpload1" runat="server" />
                                        <br />
                                    </div>
                                </div>
    <asp:Button ID="Button1" CssClass="btn btn-block btn-danger" runat="server" Text="Upload" />
    <br />
    <h3 style="color: blue">View Uploaded Slides</h3>
    <center>
        <asp:Table Width="80%" ID="Table1" runat="server" GridLines="Both"></asp:Table>
    </center>
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="ContentPlaceHoldelast" runat="server">
</asp:Content>
