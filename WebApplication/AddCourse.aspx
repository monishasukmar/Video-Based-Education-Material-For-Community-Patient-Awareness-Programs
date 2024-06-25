<%@ Page Title="" Language="vb" AutoEventWireup="false" MasterPageFile="~/Site2.Master" CodeBehind="AddCourse.aspx.vb" Inherits="WebApplication1.WebForm3" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="conMain" runat="server">
    <h3 style="color: blue">Add New Course</h3>
    <div class="form-group">
                                    <label style="color: black" class="col-md-12">Enter Course Code</label>
                                    <div class="col-md-12">
                                        <asp:TextBox class="form-control" ID="TextBox1" runat="server"></asp:TextBox>
                                        <br />
                                    </div>
                                </div>

      <div class="form-group">
                                    <label style="color: black" class="col-md-12">Enter Course Name</label>
                                    <div class="col-md-12">
                                      <asp:TextBox class="form-control" ID="TextBox2" runat="server"></asp:TextBox>
                                        <br />
                                    </div>
                                </div>

    <br />
    <center>
        <asp:Button CssClass="btn btn-block btn-primary" ID="Button1" runat="server" Text="Save" />
    </center>


</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="ContentPlaceHoldelast" runat="server">
</asp:Content>
